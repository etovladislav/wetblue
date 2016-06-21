adminModule.factory('reviewCategoryService', function (addWatchToObjectForSaveToServer, reviewService) {

    var getAllCategory = function () {
        var category = [
            {
                id: 0,
                name: 'Благодарственные письма клиентов',
                items: reviewService.getReviewByCategoryId(this.id)
            }
        ];

        angular.forEach(category, function (obj) {
            addWatchToObjectForSaveToServer.add(obj, save);
        });

        return category;
    };

    var getNewCategory = function () {

        console.log("Ображение к серверу для создания новой категории для отзывов");
        var category = {
            id: 700,
            name: 'Новая категория',
            items: []
        };

        addWatchToObjectForSaveToServer.add(category, save);
        return category;
    };

    var save = function (category) {
        console.log("сохраняю категориюю")
    };

    this.save = save;
    this.getAllCategory = getAllCategory;
    this.getNewCategory = getNewCategory;

    return this;
});