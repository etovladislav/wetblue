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
                                                                                     documentService) {

        $scope.info = infoService.getInfo();
        $scope.slideList = slideService.getAllSlide();
        $scope.product = productService.getAllProduct();
        $scope.plus = plusService.getAllPlus();
        $scope.reviewCategory = reviewCategoryService.getAllCategory();
        $scope.production = productionService.getAllProduction();
        $scope.country = countryService.getAllCountry();
        $scope.document = documentService.getAllDocument();

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

    }
)
;