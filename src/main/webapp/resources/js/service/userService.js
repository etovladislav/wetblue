adminModule.factory('userService', function ($http) {

    this.isAuth = function () {
        return $http.get('/checkAuth');
    };

    return this;
});