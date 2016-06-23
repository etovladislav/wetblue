adminModule.factory('paramService', function ($http) {


    this.save = function (param) {
        $http.post('/api/saveParam', param);
    };

    this.getNewParam = function (id) {
        return $http.get('/api/cleanParam/' + id);
    };


    this.delete = function (param) {
        $http.post('/api/deleteParam', param);
    };

    return this;
});