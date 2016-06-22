adminModule.factory('productionService', function ($http) {

    this.save = function (production) {
        $http.post('/api/saveProduction/', production);
    };

    this.getAllProduction = function () {
        return $http.get('/api/getAllProduction/');
    };

    this.getNewProduction = function () {
        return $http.get('/api/getCleanProduction/');
    };

    return this;
});