adminModule.factory('addWatchToObjectForSaveToServer', function ($rootScope) {
    
    this.add = function (object, saveFunction) {
        $rootScope.$watchCollection(function () {
            return object;
        }, function (newVal, oldVal) {
            saveFunction(newVal);
        })
    };
    return this;
});