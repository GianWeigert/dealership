package br.com.gianweigert.dealership.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gianweigert.dealership.entity.Model;
import br.com.gianweigert.dealership.repository.BrandRepository;
import br.com.gianweigert.dealership.repository.ModelRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelServiceTest {

	private ModelService modelService;

	@MockBean
	private ModelRepository modelRepository;
	
	@MockBean
	private BrandRepository brandRepository;

	@Before
	public void setUp() {
		this.modelService = new ModelService(this.modelRepository, this.brandRepository);
		Mockito.reset(this.modelRepository);
		Mockito.reset(this.brandRepository);
	}

	@Test
	public void findModelByIdCorrectly() {
		Model model = new Model();

		// Quando o método 'findByBrandId' com o argumento 1 for invocado, então retorna
		// uma lista de models
		Mockito.when(this.modelRepository.findByBrandId(1)).thenReturn(Arrays.asList(model));

		List<Model> allModels = this.modelService.findByBrandId(1);
		assertFalse(allModels.isEmpty());
		assertEquals(model, allModels.get(0));

		// confirmando que o método findByBrandId no repository foi invocado uma vez
		// (times(1))
		Mockito.verify(this.modelRepository, Mockito.times(1)).findByBrandId(1);
	}

}
