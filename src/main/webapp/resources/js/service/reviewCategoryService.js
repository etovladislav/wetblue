adminModule.factory('reviewCategoryService', function ($http) {

    this.getAllCategory = function () {
        return $http.get('/getAllReviewCategory');
    };

    this.getNewCategory = function () {
        return $http.post('/api/getCleanReviewCategory');
    };

    this.save = function (category) {
        $http.post('/api/saveReviewCategory', category);
    };


    this.delete = function (reviewCategory) {
        $http.post('/api/deleteReviewCategory', reviewCategory);
    };

    return this;
});