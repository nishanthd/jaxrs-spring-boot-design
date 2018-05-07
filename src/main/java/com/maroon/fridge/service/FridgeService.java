package com.maroon.fridge.service;

import java.util.List;

import com.maroon.fridge.dto.FridgeItem;
import com.maroon.fridge.exception.NoItemFoundException;

/**
 * 
 * @author Nishanth Dharmaraju
 *
 */
public interface FridgeService {

	List<FridgeItem> getAllItems();

	FridgeItem getItemByType(Integer itemType) throws NoItemFoundException;

}
