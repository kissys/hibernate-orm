/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2013, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.metamodel.internal.source.annotations;

import java.util.Map;

import org.hibernate.metamodel.internal.source.annotations.attribute.AssociationOverride;
import org.hibernate.metamodel.internal.source.annotations.attribute.AttributeOverride;
import org.hibernate.metamodel.internal.source.annotations.attribute.PluralAssociationAttribute;
import org.hibernate.metamodel.spi.source.PluralAttributeSource;

/**
 * @author Strong Liu <stliu@hibernate.org>
 */
public abstract class AbstractPluralAttributeElementSourceImpl implements AnnotationAttributeSource {
	private final String path;
	protected AttributeOverride attributeOverride;
	protected AssociationOverride associationOverride;

	public AbstractPluralAttributeElementSourceImpl(
			final PluralAssociationAttribute associationAttribute,
			final String relativePath) {
		if ( associationAttribute.getPluralAttributeNature() == PluralAttributeSource.Nature.MAP ) {
			this.path = relativePath + ".value";
		}
		else {
			this.path = relativePath + ".element";
		}
	}

	@Override
	public void applyAttributeOverride(Map<String, AttributeOverride> attributeOverrideMap) {
		this.attributeOverride = attributeOverrideMap.get( path );
	}

	@Override
	public void applyAssociationOverride(Map<String, AssociationOverride> associationOverrideMap) {
		this.associationOverride = associationOverrideMap.get( path );
	}
}
