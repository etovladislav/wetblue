adminModule.directive('ngReplace', function (userService, ngDialog) {
    return {
        restrict: 'AE',
        scope: {
            replace: '='
        },
        link: function ($scope, element, attrs) {
            userService.isAuth().success(function (data) {
                    if (data) {
                        element.css({"cursor": "pointer"});
                        var img = $('<img src="img/editIcon.png" class="ng-replace-edit-icon">');
                        img.css({
                            "border": "1px solid red",
                            "border-radius": "200px",
                            "background": "#fff",
                            "width": "16px",
                            "height": "16px"
                        });
                        element.prepend(img);

                        element.on('click', function () {
                                var template = "template/editInputText.html";
                                if (element[0].nodeName.toLowerCase() === 'img') {

                                    template = "template/editImg.html";
                                    var formdata = new FormData();

                                    $scope.getTheFiles = function ($files) {
                                        angular.forEach($files, function (value, key) {
                                            formdata.append(key, value);
                                        });
                                    };

                                    // NOW UPLOAD THE FILES.
                                    $scope.uploadFiles = function () {

                                        var request = {
                                            method: 'POST',
                                            url: '/api/saveImage/',
                                            data: formdata,
                                            headers: {
                                                'Content-Type': undefined
                                            }
                                        };
                                        // SEND THE FILES.
                                        $http(request)
                                            .success(function (data) {
                                                alert(data);
                                            });
                                    };
                                } else {
                                    $scope.edit = function (value) {
                                        $scope.replace = value;
                                    };
                                }
                                ngDialog.open({
                                    template: template,
                                    className: 'ngdialog-theme-default',
                                    scope: $scope
                                });
                                $scope.$apply();
                            }
                        );
                    }
                }
            );
        }
    }
})
;