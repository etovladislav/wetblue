adminModule.factory('plusService', function ($http) {

    this.getAllPlus = function () {
        return $http.get('/getAllPlus/');
    };

    this.getNewPlus = function () {
        return $http.get('/api/getCleanPlus/');
    };

    this.save = function (plus) {
        $http.post('/api/savePlus', plus);
    };


    this.delete = function (plus) {
        $http.post('/api/deletePlus/',plus);
    };

    return this;
});