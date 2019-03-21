/**
 * Website Script
 */

// Search Page
var $element = $('.speech-control-container');

$element.on('click', function(){
	$element.addClass('listen')
		.one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', 
				function () {
					$element.removeClass('listen');    
					$element.addClass('loading')
						.one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', 
								function () {
									$element.removeClass('loading');
								});
				});
});

$element.click(function() {
	startDictation();
});

// Define dictation
function startDictation() {
    if (window.hasOwnProperty('webkitSpeechRecognition')) {
        var recognition = new webkitSpeechRecognition();

        recognition.continuous = false;
        recognition.interimResults = false;

        recognition.lang = "en-US";
        recognition.start();

        recognition.onresult = function(e) {
        	document.getElementById('transcript').value = e.results[0][0].transcript;
            recognition.stop();
            document.getElementById('labnol').submit();
        };

        recognition.onerror = function(e) {
            recognition.stop();
        }

    }
}

///////////form validator
$(document).ready(function() {
	
	// Get GeoLocation 
	var url = document.location.href;
	if(url.indexOf('/share') != -1) {
		if(navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(fillGeoInfo);
		} else {
			alert("Geolocation is not supported by this browser");
		}
	}
	
	function fillGeoInfo(position){
		var latitude = position.coords.latitude;
		var langitude = position.coords.longitude;
		var apikey = 'AIzaSyARa75r2nu-mb7tycbbgRFgoSVZEJZy5eQ';
		$.get('https://maps.googleapis.com/maps/api/geocode/json?latlng=' + latitude
				+ "," + langitude + "&key=" + apikey, function(data) {
			var fullAddr = data['results'][0]['formatted_address'];
			$('#address').val(fullAddr);
		});
	}
	
	
	/**
	 * Validate Form
	 */
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	realname: {
                validators: {
                        stringLength: {
                        min: 2,
                    },
                        notEmpty: {
                        message: 'Please supply your real name'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    emailAddress: {
                        message: 'Please supply a valid email address'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your phone number'
                    },
                    phone: {
                        country: 'US',
                        message: 'Please supply a vaild phone number with area code'
                    }
                }
            },
            address: {
                validators: {
                     stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please supply your street address'
                    }
                }
            },
            city: {
                validators: {
                     stringLength: {
                        min: 4,
                    },
                    notEmpty: {
                        message: 'Please supply your city'
                    }
                }
            },
            state: {
                validators: {
                    notEmpty: {
                        message: 'Please select your state'
                    }
                }
            },
            zip: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your zip code'
                    },
                    zipCode: {
                        country: 'US',
                        message: 'Please supply a vaild zip code'
                    }
                }
            },
            comment: {
                validators: {
                      stringLength: {
                        min: 10,
                        max: 200,
                        message:'Please enter at least 10 characters and no more than 200'
                    },
                    notEmpty: {
                        message: 'Please supply a description of your project'
                    }
                    }
                }
            }
        })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
                $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});
////////end of form validate.
/////Uploading image
function readURL(input) {
    if (input.files && input.files[0]) {

        var reader = new FileReader();

        reader.onload = function(e) {
            $('.image-upload-wrap').hide();

            $('.file-upload-image').attr('src', e.target.result);
            
            ///// start adding the code 
            const image = document.getElementById('image');
            const classifier = ml5.imageClassifier('MobileNet', function() {
            	console.log('Model Loaded!!');
            });
            
            classifier.predict(image, function(err, results) {
            	$('#title').val(results[0].className);
            	$('#possibility').html(" with a confidence of " + results[0].probability.toFixed(4));
            });
            
            
            $('.file-upload-content').show();
            $('.image-title').html(input.files[0].name);
        };

        reader.readAsDataURL(input.files[0]);

    } else {
        removeUpload();
    }
}

function removeUpload() {
    $('.file-upload-input').replaceWith($('.file-upload-input').clone());
    $('.file-upload-content').hide();
    $('.image-upload-wrap').show();
}
$('.image-upload-wrap').bind('dragover', function() {
    $('.image-upload-wrap').addClass('image-dropping');
});
$('.image-upload-wrap').bind('dragleave', function() {
    $('.image-upload-wrap').removeClass('image-dropping');
});

/**
 * 
 * Image Classification - using MobileNet machine learning model trained 
 * to recognize the content of certain images.
 *  
 *  This example is built with p5.js. 
 */











































