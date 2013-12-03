var camera = {
    getPicture: function(successCallback, errorCallback){
        cordova.exec(
            successCallback,
            errorCallback,
            'Cam',
            'takePicture',
            [{}]
            );
    }
}
module.exports = camera;