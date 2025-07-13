package com.cognizant.ormlearn.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Transactional
    public List<Stock> findFacebookStocksInSeptember(Date startDate, Date endDate) {
        return stockRepository.findFacebookStocksInSeptember(startDate, endDate);
    }

    @Transactional
    public List<Stock> findGoogleStocksAbovePrice(double price) {
        return stockRepository.findGoogleStocksAbovePrice(price);
    }

    @Transactional
    public List<Stock> findTop3ByVolume() {
        return stockRepository.findTop3ByVolume();
    }

    @Transactional
    public List<Stock> findNetflixStocksByLowestPrice() {
        return stockRepository.findNetflixStocksByLowestPrice();
    }

    @Transactional
    public List<Stock> findStocksByCodeAndDateRange(String code, Date startDate, Date endDate) {
        return stockRepository.findByCodeAndDateBetweenOrderByDateAsc(code, startDate, endDate);
    }

    @Transactional
    public List<Stock> findStocksByCodeAndPriceAbove(String code, double price) {
        return stockRepository.findByCodeAndCloseGreaterThanOrderByCloseDesc(code, price);
    }

    @Transactional
    public List<Stock> findTop3StocksByVolume() {
        return stockRepository.findTop3ByOrderByVolumeDesc();
    }

    @Transactional
    public List<Stock> findTop3StocksByCodeAndLowestPrice(String code) {
        return stockRepository.findTop3ByCodeOrderByCloseAsc(code);
    }
} 