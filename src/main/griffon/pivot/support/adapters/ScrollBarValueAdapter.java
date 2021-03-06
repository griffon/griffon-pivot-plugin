/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.pivot.support.adapters;

import groovy.lang.Closure;

/**
 * @author Andres Almiray
 */
public class ScrollBarValueAdapter implements GriffonPivotAdapter, org.apache.pivot.wtk.ScrollBarValueListener {
    private Closure valueChanged;

    public Closure getValueChanged() {
        return this.valueChanged;
    }


    public void setValueChanged(Closure valueChanged) {
        this.valueChanged = valueChanged;
        if (this.valueChanged != null) {
            this.valueChanged.setDelegate(this);
            this.valueChanged.setResolveStrategy(Closure.DELEGATE_FIRST);
        }
    }


    public void valueChanged(org.apache.pivot.wtk.ScrollBar arg0, int arg1) {
        if (valueChanged != null) {
            valueChanged.call(arg0, arg1);
        }
    }

}
