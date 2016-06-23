adminModule.factory('reviewService', function ($http) {

    this.getNewReview = function (id) {
        return $http.get('/api/cleanReview/' + id);
    };

    this.save = function (rewiev) {
        $http.post('/api/saveReview', rewiev);
    };


    this.delete = function (review) {
        $http.post('/api/deleteReview', review);
    };

    return this;
});