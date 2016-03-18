package org.tomasz.shapes;

import java.util.List;

public class Triangle
{
    private Point pointA;

    private Point pointB;

    private Point pointC;
    
//    List<Point> points;

    public Point getPointA()
    {
        return pointA;
    }

    public void setPointA( Point pointA )
    {
        this.pointA = pointA;
    }

    public Point getPointB()
    {
        return pointB;
    }

    public void setPointB( Point pointB )
    {
        this.pointB = pointB;
    }

    public Point getPointC()
    {
        return pointC;
    }

    public void setPointC( Point pointC )
    {
        this.pointC = pointC;
    }

//    public List<Point> getPoints()
//    {
//        return points;
//    }
//
//    public void setPoints( List<Point> points )
//    {
//        this.points = points;
//    }

    // private String type;
    //
    // private int height;
    //
    //
    //
    // public Triangle( String type )
    // {
    // this.type = type;
    // }
    //
    // public Triangle( int height )
    // {
    // this.height = height;
    // }
    //
    // public Triangle( String type, int height )
    // {
    // this.type = type;
    // this.height = height;
    // }
    //
    // public String getType()
    // {
    // return type;
    // }
    //
    // public void setType( String type )
    // {
    // this.type = type;
    // }
    //
    // public int getHeight()
    // {
    // return height;
    // }
    public void draw()
    {
        // System.out.println( getType() + " Triangle drawn of height " + getHeight() );
        System.out.println( "Point A x: " + getPointA().getX() + " Point B x: " + getPointB().getX() + " PointC x: "
            + getPointC().getX() );
//        for (Point point : points)
//        {
//            System.out.println( "x: " + point.getX() + " y: " + point.getY() );
//        }
    }

}
