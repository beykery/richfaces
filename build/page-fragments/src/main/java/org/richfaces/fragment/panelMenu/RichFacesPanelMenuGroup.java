/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.richfaces.fragment.panelMenu;

import java.util.List;

import org.jboss.arquillian.graphene.findby.FindByJQuery;
import org.jboss.arquillian.graphene.fragment.Root;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RichFacesPanelMenuGroup extends AbstractPanelMenu {

    @FindByJQuery(".rf-pm-gr:visible")
    private List<WebElement> menuGroups;
    @FindByJQuery(".rf-pm-itm:visible")
    private List<WebElement> menuItems;
    @FindBy(css = "td[class*=rf-pm-][class*=-gr-lbl]")
    private WebElement label;
    @FindByJQuery("> div[class*=rf-pm-][class*=-gr-hdr]")
    private WebElement header;
    @FindByJQuery("td[class*=rf-pm-][class*=-gr-ico] :visible[class*=rf-pm-ico-]")
    private WebElement leftIcon;
    @FindByJQuery("td[class*=rf-pm-][class*=-gr-exp-ico] :visible[class*=rf-pm-ico-]")
    private WebElement rightIcon;

    @Root
    private WebElement root;
    private AdvancedPanelMenuGroupInteractions advancedInteractions = new AdvancedPanelMenuGroupInteractions();

    @Override
    public List<WebElement> getMenuItems() {
        return menuItems;
    }

    @Override
    public List<WebElement> getMenuGroups() {
        return menuGroups;
    }

    public AdvancedPanelMenuGroupInteractions advanced() {
        return advancedInteractions;
    }

    public class AdvancedPanelMenuGroupInteractions extends AbstractPanelMenu.AdvancedAbstractPanelMenuInteractions {

        public List<WebElement> getMenuGroupElements() {
            return menuGroups;
        }

        public List<WebElement> getMenuItemElements() {
            return menuItems;
        }

        public boolean isExpanded() {
            return super.isGroupExpanded(root);
        }

        public WebElement getLabelElement() {
            return label;
        }

        public WebElement getRootElement() {
            return root;
        }

        public boolean isTransparent(WebElement icon) {
            return icon.getAttribute("class").contains("-transparent");
        }

        public WebElement getLeftIconElement() {
            return leftIcon;
        }

        public WebElement getRightIconElement() {
            return rightIcon;
        }

        public WebElement getHeaderElement() {
            return header;
        }

        public boolean isDisabled() {
            return root.getAttribute("class").contains("-dis");
        }

        public boolean isSelected() {
            return getHeaderElement().getAttribute("class").contains("-sel");
        }
    }
}