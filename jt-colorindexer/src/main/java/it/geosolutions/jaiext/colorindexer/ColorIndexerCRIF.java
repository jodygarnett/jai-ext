/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2005-2013, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package it.geosolutions.jaiext.colorindexer;

import it.geosolutions.jaiext.range.Range;

import java.awt.RenderingHints;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;

import javax.media.jai.CRIFImpl;
import javax.media.jai.ROI;

/**
 * Slightly modified version of the existing Color inversion operation
 * 
 * @author Simone Giannecchini, GeoSolutions SAS
 * 
 * @source $URL$
 */
public class ColorIndexerCRIF extends CRIFImpl {

    public RenderedImage create(ParameterBlock pb, RenderingHints hints) {
        final RenderedImage image = (RenderedImage) pb.getSource(0);
        final ColorIndexer indeder = (ColorIndexer) pb.getObjectParameter(0);
        final ROI roi = (ROI) pb.getObjectParameter(1);
        final Range nodata = (Range) pb.getObjectParameter(2);
        final int destNoData = pb.getIntParameter(3);
        return new ColorIndexerOpImage(image, indeder, roi, nodata, destNoData, hints);
    }

}
