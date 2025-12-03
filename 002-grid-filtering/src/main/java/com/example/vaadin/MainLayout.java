package com.example.vaadin;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * The main UI layout which includes the app header and navigation.
 */
@Layout
public class MainLayout extends AppLayout {

  private H1 viewTitle;

  public MainLayout() {
    var toggle = new DrawerToggle();

    viewTitle = new H1("Dashboard");
    viewTitle.getStyle().set("font-size", "var(--lumo-font-size-l)")
        .set("margin", "0");

    var nav = createNavigation();

    var scroller = new Scroller(nav);
    scroller.setClassName(LumoUtility.Padding.SMALL);

    addToDrawer(scroller);
    addToNavbar(toggle, viewTitle);

    setPrimarySection(Section.DRAWER);
  }

  private SideNav createNavigation() {
    var nav = new SideNav();

    var menuEntries = MenuConfiguration.getMenuEntries();
    menuEntries.forEach(entry -> {
      if (entry.icon() != null) {
        nav.addItem(new SideNavItem(entry.title(), entry.path(), new SvgIcon(entry.icon())));
      } else {
        nav.addItem(new SideNavItem(entry.title(), entry.path()));
      }
    });

    return nav;
  }

  @Override
  protected void afterNavigation() {
    super.afterNavigation();
    viewTitle.setText(getCurrentPageTitle());
  }

  private String getCurrentPageTitle() {
    return MenuConfiguration.getPageHeader(getContent()).orElse("");
  }
}
