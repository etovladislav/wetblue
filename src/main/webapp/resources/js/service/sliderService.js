adminModule.factory('slideService', function ($http) {

    this.getAllSlide = function () {
        return $http.get('/api/getSliders');
    };

    this.save = function (slide) {
        return $http.post('/api/saveSlider', slide);
    };

    return this;
});