adminModule.directive('ngAdd', function (userService, addWatchToObjectForSaveToServer, ngDialog) {
    return {
        restrict: 'AE',
        scope: {
            from: '=',
            name: '@',
            itemService: '=',
            saveFunc: '=',
            param: '='
        },
        link: function ($scope, element, attrs) {
            userService.isAuth().success(function (data) {
                if (data) {
                    var button = $('<div class="ng-add-button"><p>' + $scope.name + '</p></div>');
                    element.append(button);
                    button.on('click', function () {
                        var number = $scope.from.length;
                        $scope.itemService($scope.param).success(function (data) {
                            $scope.from[number] = data;
                            addWatchToObjectForSaveToServer.add($scope.from[number], $scope.saveFunc);
                        });
                        $scope.$apply();
                    });
                }
            });
        }
    }
});