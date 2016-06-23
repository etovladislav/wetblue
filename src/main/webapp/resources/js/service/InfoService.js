adminModule.factory('infoService', function ($http) {

    this.save = function (info) {
        $http.post('/api/saveInfo',info);
    };

    this.getInfo = function () {
        return $http.get('/getInfo');
    };
    

    return this;
});