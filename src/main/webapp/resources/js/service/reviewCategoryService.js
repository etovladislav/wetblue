adminModule.factory('reviewCategoryService', function ($http) {

    this.getAllCategory = function () {
        return $http.get('/api/getAllReviewCategory');
    };

    this.getNewCategory = function () {
        return $http.post('/api/getCleanReviewCategory');
    };

    this.save = function (category) {
        $http.post('/api/saveReviewCategory', category);
    };
    return this;
});