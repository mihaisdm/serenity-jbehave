package net.serenitybdd.jbehave;

import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.StepEventBus;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WhenRunningJBehaveStories extends AbstractJBehaveStory {

    @Test
    public void for_jbehave_stories_the_test_source_is_saved_in_the_outcome() {

        // Given
        SerenityStories storyWithTitle = newStory("aBehaviorWithATitle.story");

        // When
        run(storyWithTitle);

        // Then
        List<TestOutcome> outcomes = loadTestOutcomes();
        assertThat(outcomes.size(),is(1));
        assertThat(outcomes.get(0).getTestSource(),is(StepEventBus.TEST_SOURCE_JBEHAVE));
    }
}
