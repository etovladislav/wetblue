adminModule.factory('productionService', function ($http) {

    this.save = function (production) {
        $http.post('/api/saveProduction/', production);
    };

    this.getAllProduction = function () {
        return $http.get('/getAllProduction/');
    };

    this.getNewProduction = function () {
        return $http.get('/api/getCleanProduction/');
    };


    this.delete = function (production) {
        $http.post('/api/deleteProduction/', production);
    };

    return this;
});