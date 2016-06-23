adminModule.directive('ngDelete', function (userService, ngDialog) {
    return {
        restrict: 'AE',
        scope: {
            from: '=',
            number: '=',
            funcDelete: '='
        },
        link: function ($scope, element, attrs) {
            userService.isAuth().success(function (data) {
                if (data) {
                    element.css({"cursor": "pointer"});
                    var img = $('<img src="img/stop.png" class="ng-replace-edit-icon">');
                    img.css({
                        "border": "1px solid red",
                        "border-radius": "200px",
                        "background": "#fff",
                        "width": "16px",
                        "height": "16px"
                    });
                    element.prepend(img);

                    $scope.deleteFunc = function () {
                        $scope.funcDelete($scope.from[$scope.number]);
                        $scope.from.splice($scope.number, 1);
                        ngDialog.close();
                    };

                    img.on('click', function () {
                        ngDialog.open({
                            template: 'template/deleteObj.html',
                            className: 'ngdialog-theme-default',
                            scope: $scope
                        });
                    });

                }
            });
        }
    }
});