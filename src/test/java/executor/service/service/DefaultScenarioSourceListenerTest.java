package executor.service.service;

import executor.service.model.Scenario;
import executor.service.model.Step;
import executor.service.service.holder.scenario.DefaultScenarioHolder;
import executor.service.service.holder.scenario.ScenarioHolder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultScenarioSourceListenerTest {

    private ScenarioHolder sourceListener;

    @Before
    public void setUp() {
        sourceListener = new DefaultScenarioHolder();
    }

    @Test
    public void testAppendScenarios() throws IOException {
        Collection<Scenario> expected = createScenariosLikeInFile();
        expected.addAll(createScenariosLikeInFile());
        Collection<Scenario> actual = new LinkedBlockingQueue<>();

        actual.forEach(sourceListener::addScenario);

//        assertArrayEquals(
//                expected.toArray(new Scenario[0]), actual.toArray(new Scenario[0]));
    }

    private Collection<Scenario> createScenariosLikeInFile() {
        List<Scenario> scenarios = new ArrayList<>();

        scenarios.add(new Scenario(
                "test scenario 1",
                "http://info.cern.ch",
                Stream.of(
                        new Step(
                                "clickCss",
                                "body > ul > li:nth-child(1) > a"
                        ),
                        new Step(
                                "sleep",
                                "5"
                        ),
                        new Step(
                                "clickXpath",
                                "/html/body/p"
                        )
                ).collect(Collectors.toList())
        ));
        scenarios.add(new Scenario(
                "test scenario 2",
                "http://info.cern.ch",
                Stream.of(
                        new Step(
                                "clickXpath",
                                "/html/body/p"
                        ),
                        new Step(
                                "sleep",
                                "5"
                        ),
                        new Step(
                                "clickCss",
                                "body > ul > li:nth-child(1) > a"
                        )
                ).collect(Collectors.toList())
        ));

        return scenarios;
    }
}