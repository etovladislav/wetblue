adminModule.directive('ngUpload', function (userService, ngDialog) {
    return {
        restrict: 'AE',
        scope:{
            editFunc:'='
        },
        link: function ($scope, element, attrs) {
            var button = $('<input type="submit" value="отправить">');
            var input = $('<input type="file">');
            element.append(input);
            element.append(button);
            button.on("click", function ()
            {
                var file = new FormData;
                file.append('img', input.prop('files')[0]);

                $.ajax({
                    url: '/api/saveImage',
                    data: file,
                    processData: false,
                    contentType: false,
                    type: 'POST',
                    success: function (data) {
                        $scope.editFunc(data);
                    }
                });
            })
        }
    }
})
;