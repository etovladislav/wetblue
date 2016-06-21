adminModule.factory('slideService', function (addWatchToObjectForSaveToServer) {

    var getAllSlide = function () {
        var slide = [
            {
                id: 0,
                img: 'img/slider/1.jpg',
                desc: 'Средний размер шкур 11 футов'
            },
            {
                id: 1,
                img: 'img/slider/2.jpg',
                desc: ' Шкуры получены из специальной породы овец «Джардар» '
            }
        ];

        angular.forEach(slide, function (obj) {
            addWatchToObjectForSaveToServer.add(obj, save);
        });

        return slide;
    };

    var save = function (slide) {
        console.log("Сохраняю слайд")
    };

    this.save = save;
    this.getAllSlide = getAllSlide;

    return this;
});