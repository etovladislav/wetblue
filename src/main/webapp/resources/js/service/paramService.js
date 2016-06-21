adminModule.factory('paramService', function (addWatchToObjectForSaveToServer) {

    var getParamByItemId = function (id) {
        var params = [

            {
                id: 0,
                name: 'Сорт',
                value: '1-2сорт'
            },
            {
                id: 1,
                name: 'Размер',
                value: '11 кв. футов'
            },
            {
                id: 2,
                name: 'Толщина',
                value: '1,7мм'
            },
            {
                id: 3,
                name: 'Мин. партия (кол. во шкур)',
                value: '9000 шт.'
            },
            {
                id: 4,
                name: 'Наличие',
                value: '80000 шкур'
            }
        ];

        angular.forEach(params, function (obj) {
            addWatchToObjectForSaveToServer.add(obj, save);
        });

        return params;
    };

    var save = function (param) {
        console.log("Сохроняем пааметр");
    };

    var getNewParam = function (id) {
        console.log("Ображение к серверу для создания нового параметра и ставлю на него слушателя");
        var param = {
            id: 1002,
            name: 'Имя',
            value: 'Зачение'
        };

        addWatchToObjectForSaveToServer.add(param, save);

        return param;
    };

    this.getParamByItemId = getParamByItemId;
    this.getNewParam = getNewParam;
    this.save = save;

    return this;
});