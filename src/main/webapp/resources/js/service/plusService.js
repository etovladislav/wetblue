adminModule.factory('plusService', function ($http) {

    this.getAllPlus = function () {
        return $http.get('/api/getAllPlus/');
    };

    this.getNewPlus = function () {
        return $http.get('/api/getCleanPlus/');
    };

    this.save = function (plus) {
        $http.post('/api/savePlus', plus);
    };

    return this;
});