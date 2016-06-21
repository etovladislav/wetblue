adminModule.directive('ngAdd', function (ngDialog) {
    return {
        restrict: 'AE',
        scope: {
            from: '=',
            name: '@',
            itemService: '=',
            param: '@'
        },
        link: function ($scope, element, attrs) {

            var button = $('<div class="ng-add-button"><p>' + $scope.name + '</p></div>');
            element.append(button);
            

            button.on('click', function () {
                var number = $scope.from.length;
                $scope.from[number] = $scope.itemService($scope.param);
                $scope.$apply();
            });
        }
    }
});