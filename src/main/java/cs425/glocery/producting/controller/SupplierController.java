package cs425.glocery.producting.controller;

import cs425.glocery.producting.model.Supplier;
import cs425.glocery.producting.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
//@RequestMapping(value = "/midwestenbank/secure/suppliers")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @GetMapping(value={"producting/supplier/list"})
    public ModelAndView listSuppliers(@RequestParam(defaultValue = "0") int pageno) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("suppliers", supplierService.getAllSuppliers(pageno));
        mav.addObject("currentPageNo", pageno);
        mav.addObject("now", LocalDate.now());
        mav.setViewName("supplier/list");
        return mav;
    }

    @GetMapping(value={"producting/supplier/new"})
    public String newSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        model.addAttribute("now", LocalDate.now());
        return "supplier/new";
    }

    @PostMapping(value = {"producting/supplier/new"})
    public String registerNewSupplier(
            @Valid
            @ModelAttribute("supplier")
            Supplier supplier,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "supplier/new";
        }
        supplierService.registerNewSupplier(supplier);
        return "redirect:/producting/supplier/list";
    }

}
