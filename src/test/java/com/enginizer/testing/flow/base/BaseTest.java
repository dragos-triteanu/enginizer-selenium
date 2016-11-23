package com.enginizer.testing.flow.base;

import com.enginizer.testing.TestApplication;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestApplication.class })
@DirtiesContext
public class BaseTest {
}
