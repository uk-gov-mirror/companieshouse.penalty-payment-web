package uk.gov.companieshouse.web.pps.controller.pps;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static uk.gov.companieshouse.web.pps.controller.pps.InstalmentPageController.INSTALMENT_PAGE_TEMPLATE_NAME;
import static uk.gov.companieshouse.web.pps.util.PPSTestUtility.BACK_LINK_MODEL_ATTR;
import static uk.gov.companieshouse.web.pps.util.PPSTestUtility.COMPANY_NUMBER;
import static uk.gov.companieshouse.web.pps.util.PPSTestUtility.PENALTY_REF;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gov.companieshouse.web.pps.config.PenaltyConfigurationProperties;
import uk.gov.companieshouse.web.pps.service.navigation.NavigatorService;
import uk.gov.companieshouse.web.pps.session.SessionService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class InstalmentPageControllerTest {

    private MockMvc mockMvc;

    @Mock
    private NavigatorService mockNavigatorService;

    @Mock
    private PenaltyConfigurationProperties mockPenaltyConfigurationProperties;

    @Mock
    private MessageSource mockMessageSource;

    @Mock
    private SessionService mockSessionService;

    private static final String INSTALMENT_PAGE_PATH = "/pay-penalty/company/" + COMPANY_NUMBER
            + "/penalty/" + PENALTY_REF + "/instalment-page";

    @BeforeEach
    public void setup() {
        InstalmentPageController controller = new InstalmentPageController(
                mockNavigatorService,
                mockSessionService,
                mockPenaltyConfigurationProperties,
                mockMessageSource);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Get Instalment Page - success path")
    void getRequestSuccess() throws Exception {

        this.mockMvc.perform(get(INSTALMENT_PAGE_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name(INSTALMENT_PAGE_TEMPLATE_NAME))
                .andExpect(model().attributeExists(BACK_LINK_MODEL_ATTR));
    }

}
