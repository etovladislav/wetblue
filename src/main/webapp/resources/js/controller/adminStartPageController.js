adminModule.controller('adminStartPageController', function AdminStartPageController($scope,
                                                                                     infoService,
                                                                                     slideService,
                                                                                     productService,
                                                                                     paramService,
                                                                                     itemService,
                                                                                     plusService,
                                                                                     reviewService,
                                                                                     reviewCategoryService,
                                                                                     productionService,
                                                                                     countryService,
                                                                                     documentService,
                                                                                     addWatchToObjectForSaveToServer,
                                                                                     ngDialog) {


        infoService.getInfo().success(function (data) {
            $scope.info = data;
            addWatchToObjectForSaveToServer.add($scope.info, infoService.save);
        });


        $scope.slideList = [
            {
                id: 0,
                img: 'img/slider/1.jpg',
                description: 'Средний размер шкур 11 футов'
            },
            {
                id: 1,
                img: 'img/slider/2.jpg',
                description: ' Шкуры получены из специальной породы овец «Джардар» '
            }
        ];


        productService.getAllProduct().success(function (data) {
            $scope.product = data;

            angular.forEach($scope.product, function (value, key) {
                addWatchToObjectForSaveToServer.add(value, productService.save);

                angular.forEach(value.items, function (value, key) {
                    addWatchToObjectForSaveToServer.add(value, itemService.save);

                    angular.forEach(value.params, function (value, key) {
                        addWatchToObjectForSaveToServer.add(value, paramService.save);
                    });

                });

            });

        });

        plusService.getAllPlus().success(function (data) {
            $scope.plus = data;
            angular.forEach($scope.plus, function (value, key) {
                addWatchToObjectForSaveToServer.add(value, plusService.save);
            });
        });

        reviewCategoryService.getAllCategory().success(function (data) {
            $scope.reviewCategory = data;

            angular.forEach($scope.reviewCategory, function (value, key) {
                addWatchToObjectForSaveToServer.add(value, reviewCategoryService.save);

                angular.forEach(value.review, function (value, key) {
                    addWatchToObjectForSaveToServer.add(value, reviewService.save);
                });

            });

        });


        productionService.getAllProduction().success(function (data) {
            $scope.production = data;
            angular.forEach($scope.production, function (value, key) {
                addWatchToObjectForSaveToServer.add(value, productionService.save);
            });
        });


        countryService.getAllCountry().success(function (data) {
            $scope.country = data;
            console.log($scope.country);
            angular.forEach($scope.country, function (value, key) {
                addWatchToObjectForSaveToServer.add(value, countryService.save);
            });
        });

        documentService.getAllDocument().success(function (data) {
            $scope.document = data;
            angular.forEach($scope.document, function (value, key) {
                addWatchToObjectForSaveToServer.add(value, documentService.save);
            });
        });

        $scope.productService = productService;
        $scope.itemService = itemService;
        $scope.paramService = paramService;
        $scope.infoService = infoService;
        $scope.slideService = slideService;
        $scope.plusService = plusService;
        $scope.reviewService = reviewService;
        $scope.reviewCategoryService = reviewCategoryService;
        $scope.productionService = productionService;
        $scope.countryService = countryService;
        $scope.documentService = documentService;


        $scope.openModalCallBack = function () {
            ngDialog.open({
                template: '/template/callBack.html',
                className: 'ngdialog-theme-default',
                scope: $scope
            });
        };

    }
)
;