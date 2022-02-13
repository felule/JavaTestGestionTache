package com.gestionnairetache;

import com.gestionnairetache.controller.TacheController;
import com.gestionnairetache.dto.TacheDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class GestionnaireTacheApplicationTests {

	@Autowired
	private TacheController tacheController;

	@Test
	void contextLoads() {
		assertTrue("Test controller", tacheController != null);
	}

	@Test
	void findById(){
		assertTrue("Test findById", tacheController.findById("1").getBody().getLabel().equals("premiereTache"));
	}

	@Test
	void findAll(){
		assertTrue("Test findAll", tacheController.findAll().getBody().size() == 4);
	}

	@Test
	void findAllCompleted(){
		assertTrue("Test findAllCompleted", tacheController.findAllCompleted().getBody().size() == 1);
	}

	@Test
	void newTache(){
		TacheDTO tache = new TacheDTO();
		tache.setLabel("test");
		tache.setComplete(false);
		TacheDTO ctrlTache = tacheController.newTache(tache).getBody();
		assertTrue("Test newTache",tacheController.findById(ctrlTache.getId()).getBody().getLabel().equals("test"));
	}

	@Test
	void tacheStatus(){
		boolean status = tacheController.findById("1").getBody().isComplete();
		assertTrue("Test tacheStatus", tacheController.tacheStatus("1", true).getBody().isComplete() != status);
	}

}
