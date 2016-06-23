adminModule.factory('slideService', function ($http) {

    this.getAllSlide = function () {
        return $http.get('/getSliders');
    };

    this.save = function (slide) {
        return $http.post('/api/saveSlider', slide);
    };
    

    return this;
});