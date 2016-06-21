adminModule.directive('ngReplace', function (ngDialog) {
    return {
        restrict: 'AE',
        scope: {
            replace: '='
        },
        link: function ($scope, element, attrs) {
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
                ngDialog.open({
                    template: 'template/editInputText.html',
                    className: 'ngdialog-theme-default',
                    scope: $scope
                });
                $scope.edit = function (value) {
                    $scope.replace = value;
                }

            });
        }
    }
});