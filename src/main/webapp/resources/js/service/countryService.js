adminModule.factory('countryService', function ($http) {

    this.getAllCountry = function () {
        return $http.get('/api/getAllCountry/');
    };

    this.save = function (country) {
        $http.post('/api/saveCountry/', country);
    };


    this.getNewCountry = function () {
        return $http.get('/api/getCleanCountry/');
    };

    return this;
});