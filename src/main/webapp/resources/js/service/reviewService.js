adminModule.factory('reviewService', function ($http) {

    this.getNewReview = function (id) {
        return $http.get('/api/cleanReview/' + id);
    };

    this.save = function (rewiev) {
        $http.post('/api/saveReview', rewiev);
    };

    return this;
});