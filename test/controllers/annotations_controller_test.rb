require 'test_helper'

class AnnotationsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @widget = annotations(:one)
  end

  test "should get index" do
    get widgets_url
    assert_response :success
  end

  test "should get new" do
    get new_widget_url
    assert_response :success
  end

  test "should create annotation" do
    assert_difference('Annotation.count') do
      post widgets_url, params: {widget: {body: @widget.body, creator: @widget.creator, target: @widget.target } }
    end

    assert_redirected_to widget_url(Widget.last)
  end

  test "should show annotation" do
    get widget_url(@widget)
    assert_response :success
  end

  test "should get edit" do
    get edit_widget_url(@widget)
    assert_response :success
  end

  test "should update annotation" do
    patch widget_url(@widget), params: {widget: {body: @widget.body, creator: @widget.creator, target: @widget.target } }
    assert_redirected_to widget_url(@widget)
  end

  test "should destroy annotation" do
    assert_difference('Annotation.count', -1) do
      delete widget_url(@widget)
    end

    assert_redirected_to widgets_url
  end
end
