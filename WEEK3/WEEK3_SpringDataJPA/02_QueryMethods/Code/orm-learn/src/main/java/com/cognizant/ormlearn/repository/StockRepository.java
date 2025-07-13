package com.cognizant.ormlearn.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    
    // Query Method: Find stocks by code and date range
    List<Stock> findByCodeAndDateBetweenOrderByDateAsc(String code, Date startDate, Date endDate);
    
    // Query Method: Find stocks by code where close price is greater than value
    List<Stock> findByCodeAndCloseGreaterThanOrderByCloseDesc(String code, double price);
    
    // Query Method: Find top 3 stocks by volume (descending)
    List<Stock> findTop3ByOrderByVolumeDesc();
    
    // Query Method: Find top 3 stocks by code and close price (ascending)
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
    
    // Custom Query: Find Facebook stocks in September 2019
    @Query("SELECT s FROM Stock s WHERE s.code = 'FB' AND s.date BETWEEN :startDate AND :endDate ORDER BY s.date")
    List<Stock> findFacebookStocksInSeptember(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
    
    // Custom Query: Find Google stocks with price > 1250
    @Query("SELECT s FROM Stock s WHERE s.code = 'GOOGL' AND s.close > :price ORDER BY s.close DESC")
    List<Stock> findGoogleStocksAbovePrice(@Param("price") double price);
    
    // Custom Query: Find top 3 highest volume dates
    @Query("SELECT s FROM Stock s ORDER BY s.volume DESC")
    List<Stock> findTop3ByVolume();
    
    // Custom Query: Find Netflix stocks with lowest prices
    @Query("SELECT s FROM Stock s WHERE s.code = 'NFLX' ORDER BY s.close ASC")
    List<Stock> findNetflixStocksByLowestPrice();
} 