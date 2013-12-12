package org.jbehave.web;

import org.jbehave.business.Feedback;
import org.jbehave.business.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    @Autowired
    FeedbackService feedbackService;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET, params = "search=Search")
    public String showRecipientFeedback(Model model, HttpServletRequest httpServletRequest) {
        String recipient = httpServletRequest.getParameter("recipientSearchFormId");
        model.addAttribute("feedbackInfo", new FeedbackForm());
        model.addAttribute("feedbackList",feedbackService.getFeedbacksByRecpient(recipient));
         return "newstock";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(Model model, HttpServletRequest request) {
        request.getParameter("");
        model.addAttribute("feedbackInfo", new FeedbackForm());

        model.addAttribute("feedbackList", feedbackService.getFeedbacks());
        return "newstock";
    }

    /**
     * Simply gets a new stock and shows current status.
     *
     * @return view.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("feedbackInfo") FeedbackForm feedbackForm) {

        Feedback feedback = feedbackService.addNewFeedback(feedbackForm.getSender(), feedbackForm.getRecipient(), feedbackForm.getFeedback());
        return new ModelAndView("newstock", "feedbackList", feedbackService.getFeedbacks());
    }

}

