adminModule.factory('documentService', function (addWatchToObjectForSaveToServer) {

    var getAllDocument = function () {
        var document = [
            {
                id: 0,
                name: 'Инвойс'
            },
            {
                id: 1,
                name: 'Упаковочный лист'
            },
            {
                id: 2,
                name: 'Транспортный документ'
            },
            {
                id: 3,
                name: 'Экспортная декларация'
            },
            {
                id: 4,
                name: 'Сертификат происхождения'
            },
            {
                id: 5,
                name: 'Международный'
            },
            {
                id: 6,
                name: 'ветеринарный сертификат'
            },
            {
                id: 7,
                name: 'Фитосанитарный сертификат'
            },
            {
                id: 8,
                name: 'Акт погрузки'
            },
            {
                id: 9,
                name: 'Акт по количеству и качеству товара'
            }
        ];

        angular.forEach(document, function (obj) {
            addWatchToObjectForSaveToServer.add(obj, save);
        });

        return document;
    };

    var save = function (document) {
        console.log("сохраняем документ");
    };


    var getNewDocument = function () {
        console.log("Ображение к серверу для создания нового документа");
        var document =
        {
            id: 4,
            name: 'имя документа'
        };

        addWatchToObjectForSaveToServer.add(document, save);

        return document;
    };

    this.getAllDocument = getAllDocument;
    this.save = save;
    this.getNewDocument = getNewDocument;

    return this;
});