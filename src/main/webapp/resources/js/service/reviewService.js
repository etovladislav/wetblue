adminModule.factory('reviewService', function (addWatchToObjectForSaveToServer) {

    var getReviewByCategoryId = function (id) {
        var review = [
            {
                id: 0,
                thumbImg: 'img/thank/3.jpg',
                fullImg: 'img/thank2/3.jpg',
                desc: '«Shandong Donge Ejiao» Китай'
            },
            {
                id: 1,
                thumbImg: 'img/thank/2.jpg',
                fullImg: 'img/thank2/2.jpg',
                desc: '«Wujixinghao LeatherCO.LTD» Китай'
            },

            {
                id: 2,
                thumbImg: 'img/thank/1.jpg',
                fullImg: 'img/thank2/1.jpg',
                desc: '«Caner Deri San. Tic. LTD»Турция'
            }
        ];

        angular.forEach(review, function (obj) {
            addWatchToObjectForSaveToServer.add(obj, save);
        });

        return review;
    };

    var getNewReview = function () {

        console.log("Ображение к серверу для создания нового отзыва и ставю на него слушателя");
        var review = {
            id: 2,
            thumbImg: 'img/thank/1.jpg',
            fullImg: 'img/thank2/1.jpg',
            desc: '«Отзыв>>'
        };

        addWatchToObjectForSaveToServer.add(review, save);
        return review;
    };

    var save = function (rewiev) {
        console.log("Сохраняю отзыв")
    };

    this.save = save;
    this.getReviewByCategoryId  = getReviewByCategoryId ;
    this.getNewReview = getNewReview;

    return this;
});