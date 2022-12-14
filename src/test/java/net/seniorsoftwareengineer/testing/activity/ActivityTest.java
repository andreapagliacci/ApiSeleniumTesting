package net.seniorsoftwareengineer.testing.activity;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.seniorsoftwareengineer.testing.exception.TestingException;

class ActivityTest {
    Activity activity;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
	activity = new Activity();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testActivity() throws TestingException {
	activity.execute(null);
    }

    @Test
    void testActivity_takeSnapshot() throws TestingException {
	assertThatExceptionOfType(TestingException.class).isThrownBy(() -> {
	    activity.takeSnapshot(null);
	});
    }

}
