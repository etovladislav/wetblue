adminModule.factory('itemService', function (paramService, addWatchToObjectForSaveToServer) {

    var getItemByProductId = function (id) {
        var items = [
            {
                id: 0,
                name: 'Wet Blue овчина',
                img: 'img/w1.jpg',
                params: paramService.getParamByItemId(this.id),
                price: '5 у.е.'
            },
            {
                id: 1,
                name: 'Wet Blue овчина',
                img: 'img/w1.jpg',
                params: paramService.getParamByItemId(this.id),
                price: '5 у.е.'
            }
        ];

        angular.forEach(items, function (obj) {
            addWatchToObjectForSaveToServer.add(obj, save);
        });

        return items;
    };

    var save = function (item) {
        console.log("сохраняем товар");
    };


    var getNewItem = function (id) {
        console.log("Ображение к серверу для создания нового товара и ставлю на него слушателя");
        var item =
        {
            id: 100,
            name: 'Название',
            img: 'img/w1.jpg',
            params: [],
            price: 'Цена'
        };

        addWatchToObjectForSaveToServer.add(item, save);

        return item;
    };

    this.getItemByProductId = getItemByProductId;
    this.save = save;
    this.getNewItem = getNewItem;

    return this;
});