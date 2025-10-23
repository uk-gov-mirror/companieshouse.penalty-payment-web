package uk.gov.companieshouse.web.pps.service.navigation.failure;

import org.springframework.context.MessageSource;
import uk.gov.companieshouse.web.pps.annotation.NextController;
import uk.gov.companieshouse.web.pps.config.PenaltyConfigurationProperties;
import uk.gov.companieshouse.web.pps.controller.BaseController;
import uk.gov.companieshouse.web.pps.service.navigation.NavigatorService;
import uk.gov.companieshouse.web.pps.session.SessionService;

/**
 * Mock controller class for testing missing navigation annotation {@code RequestMapping}
 * when attempting to obtain the previous controller in the journey.
 *
 * @see 'NavigatorServiceTests'
 */
@NextController(MockControllerTwo.class)
public class MockControllerOne extends BaseController {

    public MockControllerOne(
            NavigatorService navigatorService,
            SessionService sessionService,
            PenaltyConfigurationProperties penaltyConfigurationProperties,
            MessageSource messageSource) {
        super(navigatorService, sessionService, penaltyConfigurationProperties, messageSource);
    }

    @Override
    protected String getTemplateName() {
        return null;
    }
}
