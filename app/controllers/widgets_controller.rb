class WidgetsController < ApplicationController
  protect_from_forgery with: :null_session
  before_action :set_widget, only: [:show, :edit, :update, :destroy]

  # GET /annotations
  # GET /annotations.json
  def index
    @widgets = Widget.all
  end

  # GET /annotations/1
  # GET /annotations/1.json
  def show
  end

  # GET /annotations/new
  def new
    @widget = Widget.new
  end

  # GET /annotations/1/edit
  def edit
  end

  # POST /annotations
  # POST /annotations.json
  def create
    @widget = Widget.new(widget_params)
    if Person.find_by(orcid: widget_params[:creator]).nil?
      render json: @widget.errors, status: :unprocessable_entity
    end
    @this_person = Person.find_by(orcid: widget_params[:creator])
    @widget.creator = @this_person
    if Widget.find_by(id: widget_params[:target]).nil?
      @widget_leaf = Widget.new(creator: @this_person, target: nil, body: nil, description: 'website', predicate: widget_params[:target])
      @widget_leaf.save
      @widget.target = @widget_leaf
    end
    respond_to do |format|
      if @widget.save
        format.html { redirect_to @widget, notice: 'Widget was successfully created.' }
        format.json { render :show, status: :created, location: @widget }
      else
        format.html { render :new }
        format.json { render json: @widget.errors, status: :unprocessable_entity }
      end
    end
  end

  # PATCH/PUT /annotations/1
  # PATCH/PUT /annotations/1.json
  def update
    respond_to do |format|
      if @widget.update(widget_params)
        format.html { redirect_to @widget, notice: 'Widget was successfully updated.' }
        format.json { render :show, status: :ok, location: @widget }
      else
        format.html { render :edit }
        format.json { render json: @widget.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /annotations/1
  # DELETE /annotations/1.json
  def destroy
    @widget.destroy
    respond_to do |format|
      format.html { redirect_to widgets_url, notice: 'Widget was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_widget
      @widget = Widget.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def widget_params
      params.permit(:creator, :target, :body)
    end
end
